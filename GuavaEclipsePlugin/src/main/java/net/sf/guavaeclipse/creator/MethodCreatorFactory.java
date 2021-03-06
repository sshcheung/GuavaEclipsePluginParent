/*
 * Copyright 2014
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.sf.guavaeclipse.creator;

import java.util.List;

import net.sf.guavaeclipse.dto.MethodInsertionPoint;
import net.sf.guavaeclipse.exception.MehodGenerationFailedException;

import org.eclipse.jdt.core.JavaModelException;

public class MethodCreatorFactory {

  public static AbstractMethodCreator constructMethodCreator(MethodCreatorType creatorType,
      MethodInsertionPoint insertionPoint, List<String> fields) throws JavaModelException {
    AbstractMethodCreator result = null;
    switch (creatorType) {
      case EQUALS_CREATOR:
        result = new EqualsMethodCreator(insertionPoint, fields);
        break;
      case HASH_CODE_CREATOR:
        result = new HashCodeMethodCreator(insertionPoint, fields);
        break;
      case TO_STRING_CREATOR:
        result = new ToStringMethodCreator(insertionPoint, fields);
        break;
      case COMPARE_CREATOR:
        result = new CompareMethodCreator(insertionPoint, fields);
        break;
      default:
        throw new MehodGenerationFailedException("Unknown CreatorType " + creatorType.name());
    }
    return result;
  }
}
