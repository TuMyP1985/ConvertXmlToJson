**Конвектор xml текста в json**

Вся доработка только в том, что используется метод "XML.toJSONObject(text_xml)".

С использованием **Spring boot** создана веб страница, где можно 
1)ввести xml текст, и при нажатии на кнопку "**get json**",
**xml** преобразуется в **json**.

В класс **ConvectorRestController** отправляется **post** запрос, где в теле передается параметр text_xml.
Данные возвращаются в виде ResponseEntity.

Добавлен тест в классе **ConvectorRestControllerTest**, который используя **MockMvc**, формирует 
**post** запрос передавая тестовые данные xml (**TestData.TEST_STRING_XML**), и полученные результат сравнивается с тестовыми
данными json (**TestData.TEST_STRING_JSON**).







