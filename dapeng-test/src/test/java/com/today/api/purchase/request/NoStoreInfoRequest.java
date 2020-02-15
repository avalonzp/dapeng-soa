/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.today.api.purchase.request;

        import java.util.Optional;
        import com.github.dapeng.org.apache.thrift.TException;
        import com.github.dapeng.org.apache.thrift.protocol.TCompactProtocol;
        import com.github.dapeng.util.TCommonTransport;

        /**
         * Autogenerated by Dapeng-Code-Generator (2.1.1-final)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING

        *

 售罄信息请求体


        **/
        public class NoStoreInfoRequest{
        
            /**
            *

	门店号

            **/
            public String storeId ;
            public String getStoreId(){ return this.storeId; }
            public void setStoreId(String storeId){ this.storeId = storeId; }

            public String storeId(){ return this.storeId; }
            public NoStoreInfoRequest storeId(String storeId){ this.storeId = storeId; return this; }
          
            /**
            *

	SKUNO列表

            **/
            public java.util.List<String> skuNoList = new java.util.ArrayList();
            public java.util.List<String> getSkuNoList(){ return this.skuNoList; }
            public void setSkuNoList(java.util.List<String> skuNoList){ this.skuNoList = skuNoList; }

            public java.util.List<String> skuNoList(){ return this.skuNoList; }
            public NoStoreInfoRequest skuNoList(java.util.List<String> skuNoList){ this.skuNoList = skuNoList; return this; }
          
            /**
            *

	开始时间

            **/
            public long startTime ;
            public long getStartTime(){ return this.startTime; }
            public void setStartTime(long startTime){ this.startTime = startTime; }

            public long startTime(){ return this.startTime; }
            public NoStoreInfoRequest startTime(long startTime){ this.startTime = startTime; return this; }
          

        public static byte[] getBytesFromBean(NoStoreInfoRequest bean) throws TException {
          byte[] bytes = new byte[]{};
          TCommonTransport transport = new TCommonTransport(bytes, TCommonTransport.Type.Write);
          TCompactProtocol protocol = new TCompactProtocol(transport);

          new com.today.api.purchase.request.serializer.NoStoreInfoRequestSerializer().write(bean, protocol);
          transport.flush();
          return transport.getByteBuf();
        }

        public static NoStoreInfoRequest getBeanFromBytes(byte[] bytes) throws TException {
          TCommonTransport transport = new TCommonTransport(bytes, TCommonTransport.Type.Read);
          TCompactProtocol protocol = new TCompactProtocol(transport);
          return new com.today.api.purchase.request.serializer.NoStoreInfoRequestSerializer().read(protocol);
        }

        public String toString(){
          StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("\"").append("storeId").append("\":\"").append(this.storeId).append("\",");
    stringBuilder.append("\"").append("skuNoList").append("\":").append(this.skuNoList).append(",");
    stringBuilder.append("\"").append("startTime").append("\":").append(this.startTime).append(",");
    
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

          return stringBuilder.toString();
        }
      }
      