<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4>${currentNode.properties['jcr:title'].string}(<fmt:formatDate value="${currentNode.properties['published'].date.time}" type="both" dateStyle="long" timeStyle="short"/>)</h4>
<div>
    ${currentNode.properties['body'].string}
</div>
<a target="rssEntry" href="${currentNode.properties['url'].string}"><fmt:message key="label.read.more"/> </a>
