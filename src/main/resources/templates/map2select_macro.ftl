<!-- Added by wangfei 2011-09-01 -->
<#macro select source textId="" class="" blankText="" selected="" dataparams="" blank=true required=true>
	<select id="${textId}" name="${textId}" data-params="${dataparams}" class="${class}" <#if required>required</#if>>
		<#if blank><option value="">${blankText}</option></#if>
		    <#if source?exists>
    			<#list source?keys as k>
    				<option value="${k?string}" <#if selected==k?string>selected</#if> >
    		              ${source[k]}
    		     	</option>
    			</#list>
    		</#if>
	</select>
</#macro>
<!-- Added by wangfei 2011-09-01 -->
<!-- Added by wangfei 2011-09-16 -->
<#macro text source value="">
	<#if source[value]??>${source[value]}</#if>
</#macro>

<#macro checkbox source checkedList=[] textId="" disabled="">
    <#if source?exists>
        <div><input type="text" id="query-btn" class="smiddle-text f-text"/></div>
        <ul id="query-content">
            <#list source?keys as k>
                <#list checkedList as checked>
                      <#if k==checked?string>
                          <#assign isChecked = true>
                          <#break>
                      <#else>
                          <#assign isChecked = false>
                      </#if>
                </#list>
                <li>
                    <label>
                        <input type="checkbox"  name="${textId}" value="${k}" textValue="${source[k]}" <#if isChecked??&&isChecked==true>checked="checked"</#if> <#if disabled=="true"> disabled="true" </#if> />
                        <em> ${source[k]} </em>
                    </label>
                </li>
            </#list>
        </ul>
	</#if>
</#macro>
<!-- Added by wangfei 2011-09-16 -->
