from bs4 import BeautifulSoup
import requests

URL = "https://www.manhuaren.com/m1364451/"
chapterRequest = requests.get(URL)

print(chapterRequest.content)