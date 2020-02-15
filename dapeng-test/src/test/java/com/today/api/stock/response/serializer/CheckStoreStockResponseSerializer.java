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
package com.today.api.stock.response.serializer;
        import com.today.api.purchase.request.serializer.*;import com.today.api.common.serializer.*;import com.today.api.purchase.response.serializer.*;import com.today.api.stock.response.serializer.*;import com.today.api.stock.request.serializer.*;import com.today.api.stock.events.serializer.*;import com.today.api.stock.vo.serializer.*;

        import com.github.dapeng.core.*;
        import com.github.dapeng.org.apache.thrift.*;
        import com.github.dapeng.org.apache.thrift.protocol.*;

        import java.util.Optional;
        import java.util.concurrent.CompletableFuture;
        import java.util.concurrent.Future;

        /**
        * Autogenerated by Dapeng-Code-Generator (2.1.1-final)
        *
        * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        *
        **/
        public class CheckStoreStockResponseSerializer implements BeanSerializer<com.today.api.stock.response.CheckStoreStockResponse>{
        
      @Override
      public com.today.api.stock.response.CheckStoreStockResponse read(TProtocol iprot) throws TException{

      com.today.api.stock.response.CheckStoreStockResponse bean = new com.today.api.stock.response.CheckStoreStockResponse();
      TField schemeField;
      iprot.readStructBegin();

      while(true){
        schemeField = iprot.readFieldBegin();
        if(schemeField.type == TType.STOP){ break;}

        switch(schemeField.id){
          
              case 1:
              if(schemeField.type == TType.STRING){
              String elem0 = iprot.readString();
       bean.setSkuNo(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 2:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setStockNum(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 3:
              if(schemeField.type == TType.BOOL){
              boolean elem0 = iprot.readBool();
       bean.setHasSafetyStock(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
          
            default:
            TProtocolUtil.skip(iprot, schemeField.type);
          
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      validate(bean);
      return bean;
    }
    
      @Override
      public void write(com.today.api.stock.response.CheckStoreStockResponse bean, TProtocol oprot) throws TException{

      validate(bean);
      oprot.writeStructBegin(new TStruct("CheckStoreStockResponse"));

      
            oprot.writeFieldBegin(new TField("skuNo", TType.STRING, (short) 1));
            String elem0 = bean.getSkuNo();
            oprot.writeString(elem0);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("stockNum", TType.I32, (short) 2));
            Integer elem1 = bean.getStockNum();
            oprot.writeI32(elem1);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("hasSafetyStock", TType.BOOL, (short) 3));
            Boolean elem2 = bean.getHasSafetyStock();
            oprot.writeBool(elem2);
            
            oprot.writeFieldEnd();
          
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }
    
      public void validate(com.today.api.stock.response.CheckStoreStockResponse bean) throws TException{
      
              if(bean.getSkuNo() == null)
              throw new SoaException(SoaCode.StructFieldNull, "skuNo字段不允许为空");
            
    }
    
        @Override
        public String toString(com.today.api.stock.response.CheckStoreStockResponse bean)
        {return bean == null ? "null" : bean.toString();}
      }
      

      