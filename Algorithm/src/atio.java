<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="admin_top_template.jsp"/>
			<!--BEGIN INTERNAL JSP PAGE -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Process &amp; Import Data</h1>
				</div>
				
				<div class="col-lg-12"><h3 style="color:orange">[error or success message goes here]</h3></div>
				
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>Data Setup Steps</h4>
							Once you have downloaded the data in you computer, you 
							need to perform the following steps in order to import 
							them into the hope tool.</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-pills">
								<li class="active">
								<a data-toggle="tab" href="#generate_csv-pills">
								1. Generate CSV Template File</a> </li>
								<li>
								<a data-toggle="tab" href="#upload_csv-pills">2. 
								Upload CSV Ready File</a> </li>
							</ul>
							<hr>
							<!-- Tab panes -->
							<div class="tab-content">
								<div id="generate_csv-pills" class="tab-pane fade in active">
									<p>In order to upload data into the tool, it has 
									to be formatted using a template file that you 
									can download here. Please follow the instructions below. You can click on the [X] 
									button on each step to dismiss the instruction's 
									box.</p>
									
									<div class="row">
									<div class="col-lg-4 col-md-6">
										<form role="form" id="download_csv">
											<div class="panel panel-green">
												<div class="panel-heading text-center">
													Download CVS File Form </div>
												<div class="panel-body">
													<div class="form-group">
														<label>Select the Year of 
														the Statistic</label>
														
														<select id="generate_year" name="generate_year" class="form-control"></select>
													 </div>
   													<div class="form-group">
														<label>Select the Parameter 
														Related to the Statistic
														<a class="right" data-placement="right" data-toggle="tooltip" title="If you want to use a new parameter please add it on the Hope Parameters section first">
														<i class="glyphicon glyphicon-info-sign">
														</i></a></label>
														<select id="firstShowCSV_parameterList" name="firstShowCSV_parameterList" class="form-control"> </select> 
														<!-- <select class="form-control">
														<option>[Parameter 1]
														</option>
														<option>[Parameter 2]
														</option>
														<option>[Parameter 3]
														</option>
														<option>[Parameter 4]
														</option>
														</select> --> </div>
													<button class="btn btn-default" type="submit" name="generateCSVtemplate" value= "Generate CSV template">
													Generate CSV Template
													</button></div>
											</div>
										</form>
										</div>
										<div class="col-lg-1"></div>
										
										<div class="col-lg-7 col-md-6">
										<div class="alert alert-danger alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>1. Download Template:</b> 
											Using the form below, select the year 
											and parameter that you want a template 
											for. Please note that you need to download 
											one file per year, per parameter. Once 
											you have the template in your computer, 
											you can open it with MS Excel or other 
											data sheet processor.</div>
										<div class="alert alert-warning alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>2. Process Raw Data:</b> 
											Open the file that contains the corresponding 
											dataset. If necessary, you should do 
											any processing to make sure that the 
											metric to be used is a single numeric 
											value for each neighborhood. Please 
											consider that if the metric that you 
											will to use is not an index or a ratio, 
											you should determine if it makes sense 
											to transform it into one.
											<a class="right" data-placement="right" data-toggle="tooltip" title="If the metric that you will use is relative to the population, consider dividing the metric by the population of the neighborhood. For example, if you will use the number of crimes reported, you should divide it by the population of each neighborhood. Other metrics, like the averange house value, although are not indeces, are not relative to the size of the neighborhood so you can use them without further processing">
											<i class="glyphicon glyphicon-info-sign">
											</i></a></div>
										<div class="alert alert-success alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>3. Fill out the Template:</b> 
											The template file downloaded will have 
											a prefilled column with all the names 
											of the neighborhoods, US Census ID, 
											the parameter and the year you selected. 
											Fill out only the column named "STATISTIC" 
											with the correspondant metric for each 
											neighborhood.</div>
										<div class="alert alert-info alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>4. Save Changes:</b> Finally, 
											save the changes made (keep the .csv 
											file type) and proceed to the next tab 
											to import them into the tool.</div>
											
											</div></div>		
									</div>
									<div id="upload_csv-pills" class="tab-pane fade">
										<p>Once you have your data ready in the CSV template format, you can import them using the form below.
										</p>
										
									<div class="row">
									<div class="col-lg-4 col-md-6">
										<form role="form" id="import">
											<div class="panel panel-red">
												<div class="panel-heading text-center">
													Import CVS File Form </div>
												<div class="panel-body">
													<div class="form-group">
														<label>Year of the statistic to import</label>
														<select id="upload_year" name="upload_year" class="form-control"></select>
														 </div>
													<div class="form-group">
														<label>Parameter of the Statistic to import</label>
														
														<!-- <select id="uploadCSV_parameterList" name="uploadCSV_parameterList" class="form-control"></select> -->
														<select class="form-control">
														<option>[Parameter 1]
														</option>
														<option>[Parameter 2]
														</option>
														<option>[Parameter 3]
														</option>
														<option>[Parameter 4]
														</option>
														</select> </div>
													
													<div class="form-group">
                                                    <input type="file">
                                       				</div>
                                       				<br>
														
													<button class="btn btn-default" type="submit" name= "importCSV" value="Import CSV file">
													Import File
													</button></div>
											</div>
										</form>
										</div>
										<div class="col-lg-1"></div>
										
										<div class="col-lg-7 col-md-6">
										<div class="alert alert-danger alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>1. Select File:</b> 
											Use the "choose file" to select the csv file you want to import. Remember that you need to import one file per parameter per year. .</div>
										<div class="alert alert-warning alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>2. Submit:</b> 
											Once you click "Import File", the system will validate that the metrics uploaded are numbers and that the year and parameter indicated match the ones on the actual file. If everything is OK the tool will display a confirmation message..
											</div>
										<div class="alert alert-success alert-dismissable">
											<button aria-hidden="true" class="close" data-dismiss="alert" type="button">&times;
											</button><b>3. Success:</b> 
											Your "Barriers" statistics are ready! Repeat this process for all the parameters you need and then proceed to the hope parameter section.</div>
																
											</div></div>
																				</div>
							</div>
						</div>
						<!-- /.panel-body --></div>
					<!-- /.panel --></div>
				<!-- /.col-lg-6 -->
				<!--/2nd row --></div>
			<!--/END INTERNAL JSP PAGE -->

<jsp:include page="admin_bottom_template.jsp"/>
<script>
var start = new Date().getFullYear();
var end = (new Date().getFullYear())-3;
var options = "";
for(var year = start ; year >=end; year--){
  options += "<option >"+ year +"</option>";
}
document.getElementById("generate_year").innerHTML = options;
</script>

<script>
 var start = new Date().getFullYear();
var end = (new Date().getFullYear())-3;
var options = "";
for(var year = start ; year >=end; year--){
  options += "<option>"+ year +"</option>";
}
document.getElementById("upload_year").innerHTML = options;
</script>

<script>
var options = "";
<%
String[] parameterNames = (String[])request.getAttribute("parameterNames");
for(int count=0;count <10; count++){
%>
options += "<option>"+ parameterNames[<%=count%>]  +"</option>";

<% }%>
document.getElementById("firstShowCSV_parameterList").innerHTML = options;
</script>
 
 <%--
<script>
var options = "";
<%
for(int i = 0;  i <parameterNames.length; i++ ) {
%>
options += "<option>"+ <%= parameterNames[i] %>+"</option>";
<% }%>
document.getElementById("uploadCSV_parameterList").innerHTML = options;
</script>
 --%>
