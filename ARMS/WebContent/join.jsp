<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	#signMemberFormArea{
		width: 400px;
		height: 400px;
		margin: auto;
		border: 1px solid orange;
	}
	h2{
		text-align: center;
		border-bottom: 3px double brown;
	}
	table{
		width: 540px;
		margin: auto;
		text-align: center;
	}
	.td_left{
		width: 200px;
	}
	.td_right{
		
		text-align : left;
		
		width: 380px;
	} 
	#commandCell{
		text-align: center;	
	}
	
</style>

</head>
<body>
	<section id = "signMemberFormArea">
		<h2>회원가입</h2>
		<form action="" method = "POST">
		<input type = "hidden" name="num" value=""/> 
		<input type = "hidden" name="ref" value=""/> 
		<input type = "hidden" name="re_step" value=""/> 
		<input type = "hidden" name="re_level" value=""/> 
		<table>
			<tr>
			<td class = "td_left">
			<label for = "id">ID </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "id" id = "id"  required>
			</td>
			</tr>
			
            <tr>
			<td class = "td_left">
			<label for = "passwd">비밀번호 </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "passwd" id = "passwd" required>
			</td>
			</tr>
            
            <tr>
			<td class = "td_left">
			<label for = "name">이름 </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "name" id = "name" required>
			</td>
			</tr>
			
			<tr>
			<td class = "td_left">
			<label for = "dong">동 </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "dong" id = "dong" required>
			</td>
			</tr>

			<tr>
			<td class = "td_left">
			<label for = "ho">호 </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "ho" id = "ho" required>
			</td>
			</tr>
			
            <tr>
			<td class = "td_left">
			<label for = "tel">전화번호 </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "tel" id = "tel" required>
			</td>
			</tr>
			
            <tr>
			<td class = "td_left">
			<label for = "car">차량보유수 </label>
			</td>
			<td class = "td_right">
			<input type="text" name = "car" id = "car" required>
			</td>
			</tr>
            
           
			<td colspan="2" id = "commandCell">
				<input type = "submit" value = "완료"/>
				<input type = "reset" value = "다시등록"/>
                <a href=""><input type = "button" value = "메인으로"/></a>
			</td>
			
		</table>
		</form>
	</section>
</body>
</html>