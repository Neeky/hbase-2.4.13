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
package org.apache.hadoop.hbase.replication.multiwal;

import org.apache.hadoop.hbase.HBaseClassTestRule;
import org.apache.hadoop.hbase.replication.TestReplicationEndpoint;
import org.apache.hadoop.hbase.testclassification.MediumTests;
import org.apache.hadoop.hbase.testclassification.ReplicationTests;
import org.apache.hadoop.hbase.wal.RegionGroupingProvider;
import org.apache.hadoop.hbase.wal.WALFactory;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.experimental.categories.Category;

@Category({ ReplicationTests.class, MediumTests.class })
public class TestReplicationEndpointWithMultipleWAL extends TestReplicationEndpoint {

  @ClassRule
  public static final HBaseClassTestRule CLASS_RULE =
    HBaseClassTestRule.forClass(TestReplicationEndpointWithMultipleWAL.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    CONF1.set(WALFactory.WAL_PROVIDER, "multiwal");
    CONF1.set(RegionGroupingProvider.DELEGATE_PROVIDER, "filesystem");
    TestReplicationEndpoint.setUpBeforeClass();
  }
}
