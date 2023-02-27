from selenium.webdriver import Chrome
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import JavascriptException

from contextlib import suppress
import sys
import re

def main(link, episode):
  options = Options()
  options.add_argument("--no-sandbox")
  options.add_argument("--headless")
  options.add_argument("--disable-dev-shm-usage")
  options.add_argument("--remote-debugging-port=9222")

  # startup chromium
  driver = Chrome(service=Service("chromium.chromedriver"), options=options)
  driver.get(link) # visit the web page
  driver.implicitly_wait(1) # seconds

  # find expand button
  button = driver.find_element(By.CLASS_NAME, "detail-list-more")
  driver.execute_script("arguments[0].click();", button)
  driver.implicitly_wait(1) # seconds

  # find target episode
  pattern = re.compile(rf"^\D{episode}\D$")
  button_list = driver.find_elements(By.XPATH, f"//a[@class='chapteritem' and contains(text(), '{episode}')]")
  for button in button_list:
    if pattern.match(button.text): break
  print(button.get_attribute("title") or button.text)
  driver.execute_script("arguments[0].click();", button)
  driver.implicitly_wait(1) # seconds

  # multi-page multi-image handling
  url_list = []; url_count = -1
  try:
    while len(url_list) > url_count:
      url_count = len(url_list)
      img_tags = driver.find_elements(By.CSS_SELECTOR, "#cp_img img")

      # extract url from img tag
      for img in img_tags:
        url = img.get_attribute("src")
        if (url not in url_list): url_list.append(url)

      # prevent js exception
      with suppress(JavascriptException):
        driver.execute_script("nextPage()")
        # wait until loading image disapear
        WebDriverWait(driver, 1).until(
          EC.invisibility_of_element((By.CSS_SELECTOR, "img[src$='page_default_img.png']"))
        )
  except Exception as ex:
    print(ex)
  finally:
    driver.quit() # always close driver if done

  # result urls
  if (len(url_list) > 0):
    for url in url_list: print(url)
  else:
    raise Exception("no image found.")

if __name__ == "__main__":
  if len(sys.argv) > 2: main(sys.argv[1], sys.argv[2])
  else: raise Exception("please input a link as an argument.")
  