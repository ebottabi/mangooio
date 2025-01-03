<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Application metrics</title>
    <style><#include "css/skeleton.min.css"></style>
  <body>
    <div class="container">
      <div class="row">
      <div class="twelve columns">
          <h1>Request metrics</h1>
      </div>
      </div>
      <div class="row">
      <div class="twelve columns">
	      <div><input id="filter" type="text" class="u-full-width" placeholder="Start typing what you are looking for..."></div>
      </div>
      </div>
      <div class="row">
        <div class="twelve columns">
          	<table class="u-full-width">
			<thead>
			<tr>
				<th data-sort="string"><b>Status code</b></th>
				<th data-sort="string"><b>Count</b></th>
			</tr>
			</thead>
			<tbody class="searchable">
			<#list metrics?keys as prop>
				<tr>
					<td>${prop}</td>
					<td>${metrics?api.get(prop)}</td>
				</tr>
			</#list>
		  	</tbody>
		  </table>
        </div>
       </div>
	</div>
  </body>
  <script type="text/javascript"><#include "js/jquery.min.js"></script>
  <script type="text/javascript"><#include "js/stupidtable.min.js"></script>
  <script>
  $(document).ready(function(){
  	(function ($) {
          $('#filter').keyup(function () {
              var rex = new RegExp($(this).val(), 'i');
              $('.searchable tr').hide();
              $('.searchable tr').filter(function () {
                  return rex.test($(this).text());
              }).show();
          })
      }(jQuery));
	});
  </script>
</html>