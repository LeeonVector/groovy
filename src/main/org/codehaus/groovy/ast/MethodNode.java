/*
 $Id$

 Copyright 2003 (C) James Strachan and Bob Mcwhirter. All Rights Reserved.

 Redistribution and use of this software and associated documentation
 ("Software"), with or without modification, are permitted provided
 that the following conditions are met:

 1. Redistributions of source code must retain copyright
    statements and notices.  Redistributions must also contain a
    copy of this document.

 2. Redistributions in binary form must reproduce the
    above copyright notice, this list of conditions and the
    following disclaimer in the documentation and/or other
    materials provided with the distribution.

 3. The name "groovy" must not be used to endorse or promote
    products derived from this Software without prior written
    permission of The Codehaus.  For written permission,
    please contact info@codehaus.org.

 4. Products derived from this Software may not be called "groovy"
    nor may "groovy" appear in their names without prior written
    permission of The Codehaus. "groovy" is a registered
    trademark of The Codehaus.

 5. Due credit should be given to The Codehaus -
    http://groovy.codehaus.org/

 THIS SOFTWARE IS PROVIDED BY THE CODEHAUS AND CONTRIBUTORS
 ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 THE CODEHAUS OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 OF THE POSSIBILITY OF SUCH DAMAGE.

 */
package org.codehaus.groovy.ast;

import org.codehaus.groovy.ast.stmt.Statement;
import org.objectweb.asm.Constants;

/**
 * Represents a method declaration
 * 
 * @author <a href="mailto:james@coredevelopers.net">James Strachan</a>
 * @version $Revision$
 */
public class MethodNode extends MetadataNode implements Constants {

    private String name;
    private int modifiers;
    private String returnType;
    private Parameter[] parameters;
    private Statement code;
    private boolean dynamicReturnType;
    private VariableScope variableScope;
    ClassNode declaringClass;

    public MethodNode(String name, int modifiers, String returnType, Parameter[] parameters, Statement code) {
        this.name = name;
        this.modifiers = modifiers;
        this.returnType = returnType;
        this.parameters = parameters;
        this.code = code;
        if (returnType == null) {
            this.returnType = "java.lang.Object";
            this.dynamicReturnType = true;
        }
    }

    public boolean isVoidMethod() {
        return "void".equals(returnType);
    }

    public Statement getCode() {
        return code;
    }

    public void setCode(Statement code) {
        this.code = code;
    }

    public int getModifiers() {
        return modifiers;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public String getName() {
        return name;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public String getReturnType() {
        return returnType;
    }

    public VariableScope getVariableScope() {
        return variableScope;
    }

    public void setVariableScope(VariableScope variableScope) {
        this.variableScope = variableScope;
    }

    public boolean isDynamicReturnType() {
        return dynamicReturnType;
    }

    public ClassNode getDeclaringClass() {
        return declaringClass;
    }
    
    public boolean isStatic() {
        return (modifiers & ACC_STATIC) != 0;
    }
    
    public String toString() {
        return super.toString() + "[name: " + name + "]";
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
