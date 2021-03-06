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
package org.apache.hadoop.hbase;

import java.io.IOException;
import org.apache.yetus.audience.InterfaceAudience;

/**
 * Throw when failed cleanup unsuccessful initialized wal
 */
@InterfaceAudience.Public
public class FailedCloseWALAfterInitializedErrorException extends IOException {

  private static final long serialVersionUID = -5463156587431677322L;

  /**
   * constructor with error msg and throwable
   * @param msg message
   * @param t   throwable
   */
  public FailedCloseWALAfterInitializedErrorException(String msg, Throwable t) {
    super(msg, t);
  }

  /**
   * constructor with error msg
   * @param msg message
   */
  public FailedCloseWALAfterInitializedErrorException(String msg) {
    super(msg);
  }

  /**
   * default constructor
   */
  public FailedCloseWALAfterInitializedErrorException() {
    super();
  }
}
