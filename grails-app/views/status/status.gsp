<html>
    <head>
        <r:require modules="bootstrap" />
        <meta name="layout" content="main" />
    </head>
    <body>
        <div class="container" size="80%">
            <g:each status="i" in="${systems}" var="sys">
            <g:if test="${(i) % 2 == 0}">
                <div class="row-fluid">
            </g:if>
            <div class="span6" style="background-color: #f0dfd8; border: 1px solid #d6e9c6">
                <h1>${sys.name}</h1>
            </div>
            <g:if test="${(i + 1) % 2 == 0}">
        </div>
    </g:if>
</g:each>
        </div>
        </body>
        </html>