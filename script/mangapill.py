from bs4 import BeautifulSoup
import requests

chapters = []
URL = "https://mangapill.com/manga/5785/one-punch-man-official"
chapterRequest = requests.get(URL)
if chapterRequest.status_code == 200:
  chapters = list(map(lambda tag: tag['href'], BeautifulSoup(chapterRequest.content, 'html.parser').find(id='chapters').find_all('a')))
  chapters.reverse()
#print(chapters)

#pageRequest:
img = []
pageRequest = requests.get("https://mangapill.com"+chapters[0])
if pageRequest.status_code == 200:
    img = list(map(lambda tag: tag['data-src'], BeautifulSoup(pageRequest.content, 'html.parser').find_all('img')))
#print(img)

#imageDownload:
for index, link in enumerate(img):
    imageRequest = requests.get(link)
    if imageRequest.status_code == 200:
        with open("./img/one_punch_chapter{}_{}.jpg".format(1,index+1), "wb") as file:
            file.write(imageRequest.content)



