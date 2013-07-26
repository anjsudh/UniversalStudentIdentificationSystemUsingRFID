/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var click1=0,click2=0,click3=0;
function getdetails()
{
	click1=(click1+1)%2;
	if(click1==1)
	{
	document.getElementById('content1').style.border='1px grey solid';
	document.getElementById('content1').style.width='99%';
	document.getElementById('content1').innerHTML='<center><br>Enter test details:<br><br><table style="width:70%"><tr><td style="width:40%">Test id</td><td><input name="testid" type="text"/></td></tr>	<tr><td>Course id</td><td> <input type="text" pattern="^[A-Z]{2}[0-9]{4}$" name="courseid" title="Enter course id in AADDDD format(2 characters followed by 4 digits!)"></td></tr>	<tr><td>Maximum marks</td><td><input name="maximummarks" type="text"/></td></tr>	<tr><td>Question Paper Code</td><td><input name="qpapercode" type="text"/></td></tr>	<tr><td>Test Date</td><td><input name="date" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" type="text"/></td></tr><tr><td colspan="2"><br><input type="submit" class="button-style" style="padding:15px;" name="markaction" value="Create"/></td></tr></table></center>';
	}
	else
	{
	document.getElementById('content1').innerHTML='';
	document.getElementById('content1').style.border='0px';
	}
} 
function getmarkdetails()
{
	click2=(click2+1)%2;
	if(click2==1)
	{
	document.getElementById('content2').style.border='1px grey solid';
	document.getElementById('content2').style.width='99%';
document.getElementById('content2').innerHTML='<center><br>Enter :<br><br><table style="width:70%"><tr><td style="width:40%">Test id</td><td><input name="testid" type="text"/></td></tr>	<tr><td colspan="2"><br><input type="submit" class="button-style" style="padding:15px;" name="markaction" value="Update"/></td></tr></table></center>';	
    }
	else
	{
	document.getElementById('content2').innerHTML='';
	document.getElementById('content2').style.border='0px';
	}
} 
function getcoursedetails()
{
	click3=(click3+1)%2;
	if(click3==1)
	{   
	document.getElementById('content3').style.border='1px grey solid';
	document.getElementById('content3').style.width='99%';
        document.getElementById('content3').innerHTML='<center><br>Enter :<br><br><table style="width:70%">	<tr><td>Course id</td><td> <input type="text" pattern="^[A-Z]{2}[0-9]{4}$" name="courseid" title="Enter course id in AADDDD format(2 characters followed by 4 digits!)"></td></tr>	<tr><td style="width:40%">Date of first session</td><td><input name="startdate" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" type="text"/></td></tr>	<tr><td>Date of last session</td><td><input name="enddate" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" type="text"/></td></tr>     <tr><td colspan="2"><br><input type="submit" class="button-style" name="markaction" style="padding:15px;" value="Calculate"/></td></tr></table></center>';	
        }
	else
	{
	document.getElementById('content3').innerHTML='';
	document.getElementById('content3').style.border='0px';
	}
} 