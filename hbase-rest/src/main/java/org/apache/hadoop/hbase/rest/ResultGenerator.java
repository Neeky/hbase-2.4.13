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
package org.apache.hadoop.hbase.rest;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.rest.model.ScannerModel;
import org.apache.yetus.audience.InterfaceAudience;

@InterfaceAudience.Private
public abstract class ResultGenerator implements Iterator<Cell> {

  public static ResultGenerator fromRowSpec(final String table, final RowSpec rowspec,
    final Filter filter, final boolean cacheBlocks) throws IOException {
    if (rowspec.isSingleRow()) {
      return new RowResultGenerator(table, rowspec, filter, cacheBlocks);
    } else {
      return new ScannerResultGenerator(table, rowspec, filter, cacheBlocks);
    }
  }

  public static Filter buildFilter(final String filter) throws Exception {
    return ScannerModel.buildFilter(filter);
  }

  public abstract void putBack(Cell kv);

  public abstract void close();
}
