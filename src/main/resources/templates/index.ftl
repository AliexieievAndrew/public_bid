<!DOCTYPE html>
<html lang="en">

    <#assign context = springMacroRequestContext.getContextPath()/>

    <#assign var1 = "23567e24f52746ef92c470be6059d193"/>
    <#assign var2 = "4805f381d48948b1b34d6ea2daa029a3"/>
    <#assign var3 = "47fa8764e1b74f4db58f84c9db460566"/>

    <div class = "button">
        <br/>
        <a href="${context}/addInfo?path=${var1}" class="btn btn-warning btn-sm">AddPath1</a>
    </div>

    <div class = "button">
        <br/>
        <a href="${context}/addInfo?path=${var2}" class="btn btn-warning btn-sm">AddPath2</a>
    </div>

    <div class = "button">
        <br/>
        <a href="${context}/addInfo?path=${var3}" class="btn btn-warning btn-sm">AddPath3</a>
    </div>
    <#if contracts?has_content>

        <table>
            <tr>
                <th>id</th>
                <th>hash</th>
                <th>title</th>
            </tr>
            <#list contracts as contract>
            <tr>
                <th>${contract.id}</th>
                <th>${contract.hash}</th>
                <th>${contract.title}</th>
            </tr>
            </#list>
        </table>
    </#if>
</html>
