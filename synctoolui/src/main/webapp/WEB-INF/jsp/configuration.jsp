<%-- Copyright (c) 2009-2013 DuraSpace. All rights reserved.--%>
<%-- Status Page: displays configuration information for the synchronization process. --%>
<%-- Author: Daniel Bernstein --%>

<%@include file="./include/libraries.jsp"%>
<tiles:insertDefinition
  name="app-base"
  flush="true">
  <tiles:putAttribute name="primaryTab" value="configuration" cascade="true"/>
  <tiles:putAttribute
    name="content"
    cascade="true">

    <div class="yui3-g">
      <div
        id="watched-directories"
        class="yui3-u-1-2 ">
        <div class="content">
          <div class="section top">
            <div class="header">
              <span> <spring:message code="watchedDirectories" />
              </span>
              <ul class="button-bar">
                <li>
                    <form method="post" action="${pageContext.request.contextPath}/configuration/advanced">
                    
                    <label id="prependTopLevelDirLabel" title="Check this box if you want the watch directory to be included in the content id." >
                    
                    <input type="checkbox" id="prependTopLevelDir" name="prependTopLevelDir" value="true"
                      <c:if test="${prependTopLevelDir}">
                        checked 
                      </c:if>
                    />
                    Include watch directory in id

                  </label>
                  </form>
                    
                </li>

                <li>
                    <form method="post" action="${pageContext.request.contextPath}/configuration/advanced">
                    
                    <label  title="Check this box if you wish that deletes performed on files within the directories below also be performed on those files in DuraCloud." >
                    
                    <input type="checkbox" id="syncDeletes" name="syncDeletes" value="true"
                      <c:if test="${syncDeletes}">
                        checked 
                      </c:if>
                    />
                    Sync Deletes

                  </label>
                  </form>
                    
                </li>
                <li>
                  <a id="add" class="button">Add</a>
                </li>
              </ul>
              
            </div>
            <div class="body">
              <table id="directories" >
                <tbody>
                  <c:choose>
                    <c:when test="${not empty directoryConfigs}">
                      <c:forEach
                        items="${directoryConfigs}"
                        var="dc">
                        <tr>
                          <td>${dc.directoryPath}</td>
                          <td>
                            <c:if test="${directoryConfigs.size() > 1}">
                              <form action="configuration/remove" method="post">
                                <input type="hidden" name="directoryPath" value = "${dc.directoryPath}"/>
                                <button id="${dc.file.name}-remove" class="trash" type="submit" title="remove">Remove</button>
                              </form>
                            </c:if>
                          </td>
                        </tr>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <p>There are no configured directories at this time.</p>
                    </c:otherwise>
                  </c:choose>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      
            <div
        id="duracloud-configuration"
        class="yui3-u-1-2 ">
        <div class="content">
          <div class="section top">
            <div class="header">
              <span> <spring:message code="duracloudConfiguration" /></span>
              <ul class="button-bar">
                <li>
                  <a id="edit" class="button">
                    <spring:message code="edit"/>
                  </a>
                </li>
              </ul>
              <div id="add-dialog" class="dialog" style="display:none"></div>
              <div id="edit-dialog" class="dialog" style="display:none"></div>
            </div>
            <div class="body">
              <table>
                <tr>
                  <td><spring:message code="host"/></td>
                  <td>${duracloudConfiguration.host}</td>
                </tr>
                <c:if test="${not duracloudConfiguration.defaultPort}">
                  <tr>
                    <td><spring:message code="port"/></td>
                    <td>${duracloudConfiguration.port}</td>
                  </tr>
                </c:if>
                <tr>
                  <td><spring:message code="username"/></td>
                  <td>${duracloudConfiguration.username}</td>
                </tr>
                <tr>
                  <td><spring:message code="spaceId"/></td>
                  <td>${duracloudConfiguration.spaceId}</td>
                </tr>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <script src="${pageContext.request.contextPath}/static/js/configuration.js"></script>
    

  </tiles:putAttribute>
</tiles:insertDefinition>

