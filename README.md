**Конвектор xml текста в json**

Вся доработка только в том, что используется метод "XML.toJSONObject(text_xml)".

С использованием **Spring boot** создана веб страница, где можно 

1)ввести xml текст, и при нажатии на кнопку "**get json**",
**xml** преобразуется в **json**.

2)по кнопке "Send file xml" отправляем на сервер файл xml(MultipartFile), где он преобразовать его в byte[] (json).

В класс **ConvectorRestController** отправляется **post** запрос, где в теле передается параметр text_xml (String) или 
file (MultipartFile).
Данные возвращаются в виде ResponseEntity.

Добавлены тесты в классе **ConvectorRestControllerTest**, которые используя **MockMvc**, формируют **post** запрос,
передавая тестовые данные xml (**TestData.TEST_STRING_XML** либо **TestData.TEST_STRING_XML.getBytes()**), 
и полученные результат сравнивается с тестовыми
данными json (**TestData.TEST_STRING_JSON**).








