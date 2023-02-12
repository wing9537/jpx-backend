from selenium.webdriver import Chrome
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import JavascriptException

import sys
import time
from contextlib import suppress

def main(link):
  options = Options()
  options.add_argument("--no-sandbox")
  options.add_argument("--headless")
  options.add_argument("--disable-dev-shm-usage")
  options.add_argument("--remote-debugging-port=9222")

  # startup chromium
  driver = Chrome(service=Service("chromium.chromedriver"), options=options)
  driver.get(link)
  driver.implicitly_wait(1) # seconds
  # print("title:", driver.title)

  try:
    # multi-page multi-image handling
    url_list = []; url_count = -1
    start_time = time.time()
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

    # print("total:", url_count, "(pages)")
    # print("process time:", time.time() - start_time, "(s)")
    for url in url_list: print(url)

  except Exception as ex:
    print(ex)
  finally:
    driver.quit() # always close driver if done

if __name__ == "__main__":
  if len(sys.argv) > 1: main(sys.argv[1])
  else: raise Exception("please input a link as an argument.")
  