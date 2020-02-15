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
package com.today.api.stock;

      import com.github.dapeng.core.*;
      import com.github.dapeng.org.apache.thrift.*;
      import java.util.concurrent.CompletableFuture;
      import java.util.concurrent.Future;
      import java.util.ServiceLoader;
      import com.today.api.stock.StockServiceAsyncCodec.*;
      import com.today.api.stock.StockServiceSuperCodec.*;
      import com.today.api.stock.service.StockServiceAsync;

      /**
       * Autogenerated by Dapeng-Code-Generator (2.1.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING

      **/
      public class StockServiceAsyncClient implements StockServiceAsync{
      private final String serviceName;
      private final String version;

      private SoaConnectionPool pool;
      private final SoaConnectionPool.ClientInfo clientInfo;

      public StockServiceAsyncClient() {
        this.serviceName = "com.today.api.stock.service.StockService";
        this.version = "1.0.0";

        ServiceLoader<SoaConnectionPoolFactory> factories = ServiceLoader.load(SoaConnectionPoolFactory.class,getClass().getClassLoader());
        this.pool = factories.iterator().next().getPool();
        this.clientInfo = this.pool.registerClientInfo(serviceName,version);
      }

      public StockServiceAsyncClient(String serviceVersion) {
        this.serviceName = "com.today.api.stock.service.StockService";
        this.version = serviceVersion;

        ServiceLoader<SoaConnectionPoolFactory> factories = ServiceLoader.load(SoaConnectionPoolFactory.class,getClass().getClassLoader());
        this.pool = factories.iterator().next().getPool();
        this.clientInfo = this.pool.registerClientInfo(serviceName,version);
      }

      
          
            /**
            * 

# 添加标品库存信息
## 业务描述
        添加标品库存信息
## 接口依赖
        无
## 边界异常说明
        无
## 输入
        1.CreateStockRequest  添加标品库存实体
## 前置检查
        1验证字段是否有效，如门店id，供应商id，商品id调取外部服务接口是否合法
        2验证表单字段是否合法：调取商品供应商实时信息验证表单中信息是否合法
## 逻辑处理
        1.根据ownerId,ownerType,sku_no,确定唯一记录.
        2.有记录,则执行更新操作.更新为当前最新库存,并加入流水信息
        3.无记录,则插入一条记录,并加入流水信息
## 数据库变更
        1. insert into stock,stock_journal
        2.update stock

## 后置检查
        无
## 事务处理
        默认事务处理
## 输出
        1.CreateStockResponse 返回实体 包含id,详情

            **/
            
              public CompletableFuture<Void> addStockAction(com.today.api.purchase.request.CreateStockRequest request) throws SoaException{

              String methodName = "addStockAction";
              addStockAction_args addStockAction_args = new addStockAction_args();
              addStockAction_args.setRequest(request);
                

              CompletableFuture<addStockAction_result> response = (CompletableFuture<addStockAction_result>) pool.sendAsync(serviceName,version,"addStockAction",addStockAction_args, new AddStockAction_argsSerializer(), new AddStockAction_resultSerializer());

              
                  return response.thenApply((addStockAction_result result )->  null);
                
            }
            
          

        
          
            /**
            * 

# 盘点库存更改
## 业务描述
        修改库存信息
## 接口依赖
        无
## 边界异常说明
        无
## 输入
        1.UpdateInventoryRequest
## 前置检查
        1验证字段是否有效，如门店id，供应商id，商品id调取外部服务接口是否合法
        2验证表单字段是否合法：调取商品供应商实时信息验证表单中信息是否合法
## 逻辑处理
        1.直接更新库存

## 数据库变更
        1. insert into stock,stock_journal

## 后置检查
        无
## 事务处理
        默认事务处理
## 输出
        1.void 没异常就是成功更新了.

            **/
            
              public CompletableFuture<Void> updateInventoryAction(com.today.api.purchase.request.UpdateInventoryRequest request) throws SoaException{

              String methodName = "updateInventoryAction";
              updateInventoryAction_args updateInventoryAction_args = new updateInventoryAction_args();
              updateInventoryAction_args.setRequest(request);
                

              CompletableFuture<updateInventoryAction_result> response = (CompletableFuture<updateInventoryAction_result>) pool.sendAsync(serviceName,version,"updateInventoryAction",updateInventoryAction_args, new UpdateInventoryAction_argsSerializer(), new UpdateInventoryAction_resultSerializer());

              
                  return response.thenApply((updateInventoryAction_result result )->  null);
                
            }
            
          

        
          
            /**
            * 
            **/
            
              public CompletableFuture<Void> deleteStock(java.util.List<Long> ids) throws SoaException{

              String methodName = "deleteStock";
              deleteStock_args deleteStock_args = new deleteStock_args();
              deleteStock_args.setIds(ids);
                

              CompletableFuture<deleteStock_result> response = (CompletableFuture<deleteStock_result>) pool.sendAsync(serviceName,version,"deleteStock",deleteStock_args, new DeleteStock_argsSerializer(), new DeleteStock_resultSerializer());

              
                  return response.thenApply((deleteStock_result result )->  null);
                
            }
            
          

        
          
            /**
            * 

# 根据门店id或者仓库id查询该维度下的实际库存，默认从redis缓存中获取HGET对象field库存值
## 业务描述
       根据门店id或者仓库id查询该维度下的实际库存，默认从redis缓存中获取HGET对象field库存值
## 接口依赖
        无
## 边界异常说明
        无
## 输入
        1.stockId
## 前置检查
        1验证字段是否有效，如门店id，供应商id，商品id调取外部服务接口是否合法
        2验证表单字段是否合法：调取商品供应商实时信息验证表单中信息是否合法
## 逻辑处理


## 数据库变更
        无

## 后置检查
        无
## 事务处理
        默认事务处理
## 输出
        1.TStock详细信息

            **/
            
              public CompletableFuture<com.today.api.purchase.response.StockQueryResponse> getStockByOwnerId(com.today.api.purchase.request.StockQueryRequest stockQueryRequest) throws SoaException{

              String methodName = "getStockByOwnerId";
              getStockByOwnerId_args getStockByOwnerId_args = new getStockByOwnerId_args();
              getStockByOwnerId_args.setStockQueryRequest(stockQueryRequest);
                

              CompletableFuture<getStockByOwnerId_result> response = (CompletableFuture<getStockByOwnerId_result>) pool.sendAsync(serviceName,version,"getStockByOwnerId",getStockByOwnerId_args, new GetStockByOwnerId_argsSerializer(), new GetStockByOwnerId_resultSerializer());

              
                  
                      return response.thenApply((getStockByOwnerId_result result )->  result.getSuccess());
                    
                
            }
            
          

        
          
            /**
            * 

# 门店事实库存查询
## 业务描述
       根据门店id查询该维度下的实际库存
## 接口依赖
        无
## 边界异常说明
        无
## 输入
        1.storeId
## 前置检查
## 逻辑处理


## 数据库变更
        无

## 后置检查
        无
## 事务处理
        默认事务处理
## 输出
        1.TStock详细信息

            **/
            
              public CompletableFuture<com.today.api.purchase.response.ListSkuStockByStoreCodeResponse> listSkuStockByStoreCode(com.today.api.purchase.request.ListSkuStockByStoreCodeRequest request) throws SoaException{

              String methodName = "listSkuStockByStoreCode";
              listSkuStockByStoreCode_args listSkuStockByStoreCode_args = new listSkuStockByStoreCode_args();
              listSkuStockByStoreCode_args.setRequest(request);
                

              CompletableFuture<listSkuStockByStoreCode_result> response = (CompletableFuture<listSkuStockByStoreCode_result>) pool.sendAsync(serviceName,version,"listSkuStockByStoreCode",listSkuStockByStoreCode_args, new ListSkuStockByStoreCode_argsSerializer(), new ListSkuStockByStoreCode_resultSerializer());

              
                  
                      return response.thenApply((listSkuStockByStoreCode_result result )->  result.getSuccess());
                    
                
            }
            
          

        
          
            /**
            * 

# 简单库存列表查询
## 接口依赖
            无
## 注意事项


# 简单库存列表查询
## 业务描述
            简单库存列表查询
## 接口依赖
            无
## 边界异常说明
            无
## 输入
            无
## 前置检查
            无
##  权限检查
            无
##  逻辑处理
            无
## 数据库变更
            无
##  事务处理
            无
##  输出
            无

            **/
            
              public CompletableFuture<com.today.api.purchase.response.ListStockByStoreIdResponse> listStockByStoreId(com.today.api.purchase.request.ListStockByStoreIdRequest request) throws SoaException{

              String methodName = "listStockByStoreId";
              listStockByStoreId_args listStockByStoreId_args = new listStockByStoreId_args();
              listStockByStoreId_args.setRequest(request);
                

              CompletableFuture<listStockByStoreId_result> response = (CompletableFuture<listStockByStoreId_result>) pool.sendAsync(serviceName,version,"listStockByStoreId",listStockByStoreId_args, new ListStockByStoreId_argsSerializer(), new ListStockByStoreId_resultSerializer());

              
                  
                      return response.thenApply((listStockByStoreId_result result )->  result.getSuccess());
                    
                
            }
            
          

        
          
            /**
            * 
            **/
            
              public CompletableFuture<com.today.api.purchase.response.InventoryTransOutQueryResponse> listInventoryTransOutInfo(com.today.api.purchase.request.InventoryTransOutQueryRequest request) throws SoaException{

              String methodName = "listInventoryTransOutInfo";
              listInventoryTransOutInfo_args listInventoryTransOutInfo_args = new listInventoryTransOutInfo_args();
              listInventoryTransOutInfo_args.setRequest(request);
                

              CompletableFuture<listInventoryTransOutInfo_result> response = (CompletableFuture<listInventoryTransOutInfo_result>) pool.sendAsync(serviceName,version,"listInventoryTransOutInfo",listInventoryTransOutInfo_args, new ListInventoryTransOutInfo_argsSerializer(), new ListInventoryTransOutInfo_resultSerializer());

              
                  
                      return response.thenApply((listInventoryTransOutInfo_result result )->  result.getSuccess());
                    
                
            }
            
          

        
          
            /**
            * 
            **/
            
              public CompletableFuture<Void> updateStockByStoreAndSkuNos(String storeId,java.util.List<String> skuNoList) throws SoaException{

              String methodName = "updateStockByStoreAndSkuNos";
              updateStockByStoreAndSkuNos_args updateStockByStoreAndSkuNos_args = new updateStockByStoreAndSkuNos_args();
              updateStockByStoreAndSkuNos_args.setStoreId(storeId);
                updateStockByStoreAndSkuNos_args.setSkuNoList(skuNoList);
                

              CompletableFuture<updateStockByStoreAndSkuNos_result> response = (CompletableFuture<updateStockByStoreAndSkuNos_result>) pool.sendAsync(serviceName,version,"updateStockByStoreAndSkuNos",updateStockByStoreAndSkuNos_args, new UpdateStockByStoreAndSkuNos_argsSerializer(), new UpdateStockByStoreAndSkuNos_resultSerializer());

              
                  return response.thenApply((updateStockByStoreAndSkuNos_result result )->  null);
                
            }
            
          

        
          
            /**
            * 
            **/
            
              public CompletableFuture<Void> calculateElemStock() throws SoaException{

              String methodName = "calculateElemStock";
              calculateElemStock_args calculateElemStock_args = new calculateElemStock_args();
              

              CompletableFuture<calculateElemStock_result> response = (CompletableFuture<calculateElemStock_result>) pool.sendAsync(serviceName,version,"calculateElemStock",calculateElemStock_args, new CalculateElemStock_argsSerializer(), new CalculateElemStock_resultSerializer());

              
                  return response.thenApply((calculateElemStock_result result )->  null);
                
            }
            
          

        

      /**
      * getServiceMetadata
      **/
      public String getServiceMetadata() throws SoaException {
        String methodName = "getServiceMetadata";
        getServiceMetadata_args getServiceMetadata_args = new getServiceMetadata_args();
        getServiceMetadata_result response = pool.send(serviceName,version,methodName,getServiceMetadata_args, new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer());
        return response.getSuccess();
      }

      /**
      * echo
      **/
      public String echo() throws SoaException {
        String methodName = "echo";
        echo_args echo_args = new echo_args();
        echo_result response = pool.send(serviceName,version,methodName,echo_args, new echo_argsSerializer(), new echo_resultSerializer());
        return response.getSuccess();
      }
    }
    