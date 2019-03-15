// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.optimizer.operator;

import com.google.common.collect.Lists;
import org.apache.doris.analysis.BaseTableRef;
import org.apache.doris.optimizer.rule.OptRule;
import org.apache.doris.optimizer.rule.implementation.OlapScanRule;

import java.util.List;

public class OptLogicalScan extends OptLogical {

    private BaseTableRef ref;

    public OptLogicalScan() {
        super(OptOperatorType.OP_LOGICAL_SCAN);
    }

    public OptLogicalScan(BaseTableRef ref) {
        super(OptOperatorType.OP_LOGICAL_SCAN);
        this.ref = ref;
    }

    @Override
    public List<OptRule> getCandidateRulesForExplore() { return Lists.newArrayList(); }

    @Override
    public List<OptRule> getCandidateRulesForImplement() {
        final List<OptRule> rules = Lists.newArrayList();
        rules.add(OlapScanRule.INSTANCE);
        return rules;
    }
}
