<!DOCTYPE html>
<html>
    <head>
        <title>Мои заметки</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        </head>
    <body>
    	<div class="controls">
	    	<div class="note_add_form">
		    	<form name="message" action="/" method="post">
				      <input type="text" name="title" placeholder="Заголовок"/><br/>
				      <input type="text" name="text" placeholder="Текст" required/><br/>
				      <input type="submit" value="Отправить" />
			    </form>
		    </div>
		    <div class="filter">
		    	<form name="message" action="/filter" method="post">
				      <input type="text" name="filter_text" placeholder="Фильтр" <#if model.filter_text??> value="${model.filter_text}"</#if>/>
				      <br/>
				      <input type="submit" value="Применить" />
			    </form>
		    </div>
	    </div>
		<div class="noteblock">
		 <#list model["notes"] as note>
      		<div class="message">
				<#if note.title??><b>${note.title}</b></#if>
				<form name="delete_form" action="/delete" method="post">
					<input type="hidden" name="delete_id" value="${note.id}">
					<input type="submit" value="x" />
			    </form>
			    </br>
				${note.text}
			</div>
    	</#list>
    	</div>
    </body>
</html>