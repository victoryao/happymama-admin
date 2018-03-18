<!--<font color="#000000"> 当前页:第${pageView.currentpage}页 | 总记录数:${pageView.totalrecord}条 | 每页显示:${pageView.maxresult}条 | 总页数:${pageView.totalpage}页</font>-->　
<#if pageView.pageindex.endindex!=0>
<div style="text-align:center">
    <ul class="pagination pagination-lg">
        <#list pageView.pageindex.startindex..pageView.pageindex.endindex as wp>

            <#if pageView.currentpage==wp>
                <li><a><b><font color="#000000">${wp}</font></b></a></li>
            </#if>

            <#if pageView.currentpage!=wp>
                <li><a href="javascript:topage('${wp}')" class="a03">${wp}</a></li>
            </#if>

        </#list>
    </ul>
</div>
</#if>