/*
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
package org.apache.geode_examples.clientSecurity;

import org.apache.geode.LogWriter;
import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.security.AuthInitialize;
import org.apache.geode.security.AuthenticationFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ExampleAuthInit implements AuthInitialize {

  private static final Logger logger = LogManager.getLogger();

  private static final String USER_NAME = "security-username";
  private static final String PASSWORD = "security-password";

  /**
   * The implementer would use their existing infrastructure (e.g., ldap) here to populate these
   * properties with the user credentials. These properties will in turn be handled by the
   * implementer's design of SecurityManager to authenticate users and authorize operations.
   */
  @Override
  public Properties getCredentials(Properties securityProps) throws AuthenticationFailedException {
    Properties credentials = new Properties();
    credentials.setProperty(USER_NAME, "developer_L7yKDmDWeCfB27YT2qjGRw");
    credentials.setProperty(PASSWORD, "skkAlK2x2sVLjGDb1MyIA");
    return credentials;
  }

  @Override
  public void close() {}

  @Override
  @Deprecated
  public void init(LogWriter systemLogger, LogWriter securityLogger)
      throws AuthenticationFailedException {}

  @Override
  @Deprecated
  public Properties getCredentials(Properties securityProps, DistributedMember server,
      boolean isPeer) throws AuthenticationFailedException {
    return getCredentials(securityProps);
  }
}
