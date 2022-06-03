##Конвектор xml текста в json.

###Задача          
_Разработать **RestAPI** сервис, который будет принимать **POST** запрос в теле которого будет находится XML документ
и конвертировать его в JSON и возвращать ответом на запрос.
Продемонстрировать работу веб сервиса через любой **инструмент тестирования API**_

_Пример
XML:_

    <?xml version="1.0" encoding="UTF-8"?>
    <PropertyList>
       <Property>
        <Name>CommandTimeout</Name>
        <Value>60</Value>
        <Description>Setting the timeout(in seconds)</Description>
        <DefaultValue></DefaultValue>
       </Property>
       <Property>
        <Name>Address</Name>
        <Value>0.0.0.0</Value>
        <Description>ip:port</Description>
        <DefaultValue></DefaultValue>
       </Property>
    </PropertyList>


_JSON:_

    [
     {
      "Name": "CommandTimeout",
      "Value": "60",
      "Description": "Setting the timeout(in seconds)",
      "DefaultValue": []
     },
     {
      "Name": "Address",
      "Value": "0.0.0.0",
      "Description": "ip:port",
      "DefaultValue": []
     }
    ]

###Реализация      
Основной код - использование метода "XML.toJSONObject(text_xml)" для преобразования xml в  json.    
С использованием **Spring boot** создана веб страница, где можно 

1)ввести xml текст, и при нажатии на кнопку **"get json"**,
**xml** преобразуется в **json**  и будет возвращен.        
2)по кнопке **"Send file xml"** отправляем на сервер файл xml(MultipartFile), где он преобразовать его в byte[] (json) и будет возвращен.

В класс **ConvectorRestController** отправляется **post** запрос, где в теле передается параметр text_xml (String) или 
file (MultipartFile).
Данные возвращаются в виде ResponseEntity.

Добавлены тесты в классе **ConvectorRestControllerTest**, которые используя **MockMvc**, формируют **post** запрос,
передавая тестовые данные xml (**TestData.TEST_STRING_XML** либо **TestData.TEST_STRING_XML.getBytes()**), 
и полученные результат сравнивается с тестовыми
данными json (**TestData.TEST_STRING_JSON**).

**p.s.:** Сложности возникли с передачей файла на сервер (в теле post), потрачено порядка 8 часов (не работал с этим).  
Сначала сделал с передачей текста (чтобы понять как работает),
затем уже сделал RestAPI, который принимает файл xml и возвращает в ResponseEntity byte[] (json).

    "Продемонстрировать работу веб сервиса через любой инструмент тестирования API".     
Тут не совсем понял, продемонстрировали ли я эту работу как было необходимо в задании:  
В тестовом классе поднимается "webApplicationContext", строится mockMvc, и использую метод "perform", отправляются post
запросы с параметрами в RestApi.
Возвращаемые данные сравниваются с шаблоном (как должно быть).








