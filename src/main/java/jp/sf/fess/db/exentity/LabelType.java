/*
 * Copyright 2009-2013 the Fess Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package jp.sf.fess.db.exentity;

import java.util.ArrayList;
import java.util.List;

import jp.sf.fess.db.bsentity.BsLabelType;

import org.seasar.framework.util.StringUtil;

/**
 * The entity of LABEL_TYPE.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class LabelType extends BsLabelType {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    private String[] roleTypeIds;

    private List<String> roleValueList;

    public String[] getRoleTypeIds() {
        if (roleTypeIds == null) {
            return StringUtil.EMPTY_STRINGS;
        }
        return roleTypeIds;
    }

    public void setRoleTypeIds(final String[] roleTypeIds) {
        this.roleTypeIds = roleTypeIds;
    }

    public List<String> getRoleValueList() {
        if (roleValueList == null) {
            roleValueList = new ArrayList<String>();
            for (final LabelTypeToRoleTypeMapping mapping : getLabelTypeToRoleTypeMappingList()) {
                roleValueList.add(mapping.getRoleType().getValue());
            }
        }
        return roleValueList;
    }

}
