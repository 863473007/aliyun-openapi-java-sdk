/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.trademark.model.v20180724;

import com.aliyuncs.RpcAcsRequest;

/**
 * @author auto create
 * @version 
 */
public class CheckLoaFillRequest extends RpcAcsRequest<CheckLoaFillResponse> {
	
	public CheckLoaFillRequest() {
		super("Trademark", "2018-07-24", "CheckLoaFill", "Trademark");
	}

	private String ossKey;

	private String type;

	public String getOssKey() {
		return this.ossKey;
	}

	public void setOssKey(String ossKey) {
		this.ossKey = ossKey;
		if(ossKey != null){
			putQueryParameter("OssKey", ossKey);
		}
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
		if(type != null){
			putQueryParameter("Type", type);
		}
	}

	@Override
	public Class<CheckLoaFillResponse> getResponseClass() {
		return CheckLoaFillResponse.class;
	}

}
