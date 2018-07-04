package com.support.android.designlibdemo.Connector;

import com.support.android.designlibdemo.Connector.model.Coin;
import com.support.android.designlibdemo.Connector.model.TransactionStatus;
import com.support.android.designlibdemo.Connector.model.Wallet;
import com.support.android.designlibdemo.Connector.model.WalletFile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WalletService {

    @GET("support/wallet/list")
    Call<List<Coin>> getSupportedCoins();

    @FormUrlEncoded
    @POST("wallet/")
    Call<WalletFile> createWallet(@Path("symbol") String symbol, @Field("name") String name, @Field("description")  String description, @Field("password")  String password, @Field("major")boolean major, @Field("visible") boolean visible);

    @GET("wallet/list")
    Call<List<Wallet>> getWalletList();

    @GET("wallet/balance")
    Call<String> getBalance(@Query("address") String address);

    @GET("wallet/price")
    Call<String> getPrice(@Query("address") String address);

    @GET("wallet/{symbol}/price/all")
    Call<String> getTotalPrice(@Path("symbol") String symbol);

    @GET("wallet/{symbol}/balance/all")
    Call<String> getTotalBalance(@Path("symbol") String symbol);

    @GET("wallet")
    Call<Wallet> getWalletInfo(@Query("address") String address);

    @GET("wallet/{symbol}/transaction")
    Call<TransactionStatus> getTransactionStatus(@Path("symbol") String symbol, @Query("hash") String hash);

    @GET("wallet/{symbol}/transaction/count")
    Call<Integer> getTransactionCount(@Path("symbol") String symbol, @Query("address") String address);

    @GET("/wallet/transaction/list")
    Call<List<TransactionStatus>> addressTransactionList(@Query("address") String address);

    @GET("/transaction/list")
    Call<List<TransactionStatus>> transactionList();
}
