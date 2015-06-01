# Copyright 2013 SIB Visions GmbH
# 
# Licensed under the Apache License, Version 2.0 (the "License"); you may not
# use this file except in compliance with the License. You may obtain a copy of
# the License at
# 
# http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# License for the specific language governing permissions and limitations under
# the License.


Deployment
~~~~~~~~~~

Use ANT build.xml

Start target: start.webcontent

Afterwards, reload "WebContent" folder and start the application server in Eclipse.


The target: start.complete (= default) will create a war file for manual deployment.


Start URLs
~~~~~~~~~~

WebUI:
http://localhost:8080/Demoerp/web/ui

JNLP Application: 
http://localhost:8080/Demoerp/application.jnlp

Applet:           
http://localhost:8080/Demoerp/


Login: 
admin / admin
manager / manager
sales / sales

(see db.sql for a full userlist)