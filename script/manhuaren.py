from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
# from webdriver_manager.chrome import ChromeDriverManager

options = Options()
options.add_argument('--no-sandbox')
options.add_argument('--headless')
options.add_argument('--disable-dev-shm-usage')
options.add_argument("--remote-debugging-port=9222")

try:
  driver = webdriver.Chrome(executable_path="chromium.chromedriver", chrome_options=options)
  driver.get("https://www.google.com")
  print(driver.title)
  driver.quit()
except Exception as ex:
  print(ex)
