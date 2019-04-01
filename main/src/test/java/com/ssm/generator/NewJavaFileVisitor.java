package com.ssm.generator;

import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.List;

/*
 *  Copyright 2008 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
public class NewJavaFileVisitor extends ASTVisitor {

    private List<ASTNode> newNodes;
    private List<ImportDeclaration> imports;
    private Type superclass;
    private boolean isInterface;
    private List<Type> superInterfaceTypes;

    /**
     *
     */
    public NewJavaFileVisitor() {
        super();
        newNodes = new ArrayList<ASTNode>();
    }

    public boolean visit(FieldDeclaration node) {
        newNodes.add(node);

        return false;
    }

    public boolean visit(EnumDeclaration node) {
        newNodes.add(node);

        return false;
    }

    public boolean visit(MethodDeclaration node) {
        newNodes.add(node);

        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean visit(TypeDeclaration node) {
        // make sure we don't pick up the top level class
        if (node.getParent().getNodeType() == ASTNode.COMPILATION_UNIT) {
            isInterface = node.isInterface();

            superclass = node.getSuperclassType();

            superInterfaceTypes = node.superInterfaceTypes();

            return true;
        } else {
            newNodes.add(node);
            return false;
        }
    }

    public List<ASTNode> getNewNodes() {
        return newNodes;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean visit(CompilationUnit node) {
        imports = node.imports();

        return true;
    }

    public List<ImportDeclaration> getImports() {
        return imports;
    }

    public Type getSuperclass() {
        return superclass;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public List<Type> getSuperInterfaceTypes() {
        return superInterfaceTypes;
    }
}
