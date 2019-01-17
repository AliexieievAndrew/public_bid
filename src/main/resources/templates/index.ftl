<!DOCTYPE html>
<html lang="en">

    <#assign context = springMacroRequestContext.getContextPath()/>

    <#assign var1 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/23567e24f52746ef92c470be6059d193/documents"/>
    <#assign var2 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents"/>
    <#assign var3 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents"/>

    <div class = "button">
        <br/>
        <a href="${context}/getInfo?path=${var1}" class="btn btn-warning btn-sm">AddPath1</a>
    </div>

    <div class = "button">
        <br/>
        <a href="${context}/getInfo?path=${var2}" class="btn btn-warning btn-sm">AddPath2</a>
    </div>

    <div class = "button">
        <br/>
        <a href="${context}/getInfo?path=${var3}" class="btn btn-warning btn-sm">AddPath3</a>
    </div>
    <#if contracts?has_content>

        <table>
            <tr>
                <th>idPrimary</th>
                <th>hash</th>
                <th>title</th>
            </tr>
            <#list contracts as contract>
            <tr>
                <th>${contract.idPrimary}</th>
                <th>${contract.hash}</th>
                <th>${contract.title}</th>
            </tr>
            </#list>
        </table>
    </#if>
</html>
