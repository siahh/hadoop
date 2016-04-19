/**
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
package org.apache.hadoop.yarn.api.records;

import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Evolving;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.yarn.util.Records;

/**
 * Specific AMBlacklistingRequest from AM to enable/disable blacklisting.
 */
@Public
@Evolving
public abstract class AMBlackListingRequest {

  @Private
  @Unstable
  public static AMBlackListingRequest newInstance(
      boolean isAMBlackListingEnabled, float disableFailureThreshold) {
    AMBlackListingRequest blackListRequest = Records
        .newRecord(AMBlackListingRequest.class);
    blackListRequest.setBlackListingEnabled(isAMBlackListingEnabled);
    blackListRequest
        .setBlackListingDisableFailureThreshold(disableFailureThreshold);
    return blackListRequest;
  }

  /**
   * @return AM Blacklisting is enabled.
   */
  @Public
  @Evolving
  public abstract boolean isAMBlackListingEnabled();

  /**
   * @return AM Blacklisting disable failure threshold
   */
  @Public
  @Evolving
  public abstract float getBlackListingDisableFailureThreshold();

  @Private
  @Unstable
  public abstract void setBlackListingEnabled(boolean isAMBlackListingEnabled);

  @Private
  @Unstable
  public abstract void setBlackListingDisableFailureThreshold(
      float disableFailureThreshold);
}