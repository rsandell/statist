<!DOCTYPE html>
<html lang="en">
   <head>
      <title>
        <g:layoutTitle/>
      </title>
       <g:layoutHead/>
       <r:require modules="bootstrap"/>
       
       	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
       <r:layoutResources/>
   </head>
   
   <body>
    <div class="container" size="90%">
      <div class="navbar">
         <div class="navbar-inner">
            <a class="brand" href="/statist">Statist</a>
            <ul class="nav">
               <li><a href="/statist/statusItem">StatusItem</a></li>
               <li><a href="/statist/user">Users</a></li>
               <li><a href="/statist/tag">Tags</a></li>
               <li><a href="/statist/system">System</a></li>
            </ul>
         </div>
      </div>
      
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
             
      <r:layoutResources/>
      </div>
   </body>
   
   
</html>