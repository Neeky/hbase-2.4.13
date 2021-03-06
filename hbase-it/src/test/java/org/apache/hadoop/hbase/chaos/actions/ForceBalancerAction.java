/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.chaos.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Action that tries to force a balancer run.
 */
public class ForceBalancerAction extends Action {
  private static final Logger LOG = LoggerFactory.getLogger(ForceBalancerAction.class);

  @Override
  protected Logger getLogger() {
    return LOG;
  }

  @Override
  public void perform() throws Exception {
    // Don't try the flush if we're stopping
    if (context.isStopping()) {
      return;
    }
    getLogger().info("Balancing regions");
    forceBalancer();
  }
}
