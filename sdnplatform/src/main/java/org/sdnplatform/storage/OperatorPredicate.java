/*
 * Copyright (c) 2011,2013 Big Switch Networks, Inc.
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *      http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *    Originally created by David Erickson, Stanford University 
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the
 *    License. You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an "AS
 *    IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *    express or implied. See the License for the specific language
 *    governing permissions and limitations under the License. 
 */

package org.sdnplatform.storage;

/** Predicate class to specify rows by equality or comparison operations
 * of column values. The Storage API uses the special column name of "id"
 * to specify the primary key values for the row.
 * 
 * @author rob
 */
public class OperatorPredicate implements IPredicate {
    
    public enum Operator { EQ, LT, LTE, GT, GTE };
    
    private String columnName;
    private Operator operator;
    private Comparable<?> value;
    
    public OperatorPredicate(String columnName, Operator operator, Comparable<?> value) {
        this.columnName = columnName;
        this.operator = operator;
        this.value = value;
    }
    
    public String getColumnName() {
        return columnName;
    }
    
    public Operator getOperator() {
        return operator;
    }
    
    public Comparable<?> getValue() {
        return value;
    }
}
