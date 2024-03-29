import requests as req
from statistics import mean

def check_url(url: str, count: int):
    list = []
    with open('check_url.txt', 'a+') as f:
        for i in range(count):
            try:
                req_url = req.get(url)
                r = req_url.status_code
                t = round(req_url.elapsed.total_seconds(), 5)
                list.append(t)
                f.writelines(f'Статус ответа: {r}, Время ответа: {t} \n')
            except req.ConnectionError as e:
                print("Ошибка подключения:", e)
            except req.Timeout as e:
                print("Ошибка тайм-аута:", e)
            except req.RequestException as e:
                print("Ошибка запроса:", e)
        list_avg = round(mean(list), 5)
        f.write(f'Среднее время ответа: {list_avg} \n')
        f.write('-'*20+'\n')


url = 'https://www.google.com'
check_url(url, 3)

