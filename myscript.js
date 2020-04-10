function val()
{
	var t=true;
 	var a=document.getElementsByTagName("input");
	if(a[0].value.length!=5)
	{
		t=false
		alert("Roll Number Must be of 5 digits")
	}
	if(a[1].value.length==0)
	{
		t=false
		alert("Name field should not be blank");
	}
	return t;
}