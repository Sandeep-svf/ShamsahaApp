package com.shamsaha.retrofit;


import com.shamsaha.victim.model.AboutBoardMemberModel;
import com.shamsaha.victim.model.AboutModel;
import com.shamsaha.victim.model.CommonModel;
import com.shamsaha.victim.model.ContactUsDataModel;
import com.shamsaha.victim.model.HomeModel;
import com.shamsaha.victim.model.ResourceCategoryModel;
import com.shamsaha.victim.model.ResourcesCountryModel;
import com.shamsaha.victim.model.SSTModel;
import com.shamsaha.victim.model.SSTModelNew;
import com.shamsaha.victim.model.VolunteerLoginModel;
import com.shamsaha.victim.viewmodel.VolunteerLoginBody;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("home")
    Call<HomeModel> HOME_MODEL_CALL (@Field("language") String language);

    @FormUrlEncoded
    @POST("resource_location")
    Call<ResourcesCountryModel> RESOURCES_COUNTRY_MODEL_CALL(@Field("language") String language);

    @FormUrlEncoded
    @POST("resource_category")
    Call<ResourceCategoryModel> RESOURCE_CATEGORY_MODEL_CALL (@Field("language") String language,@Field("location") String location);

    @FormUrlEncoded
    @POST("Con_message")
    Call<CommonModel> COMMON_MODEL_CONTACT_US_CALL (@Field("name") String name,
                                                    @Field("phone") String phone,
                                                    @Field("email") String email,
                                                    @Field("message") String message);

    @FormUrlEncoded
    @POST("Contactus")
    Call<ContactUsDataModel> CONTACT_US_DATA_CALL (@Field("language") String language);

    @GET("shamsha/core_script/survivor_tools.php")
    Call<SSTModelNew> SST_MODEL_CALL();


   /* @POST("Get_involved")
    @Call<> ();*/

    @FormUrlEncoded
    @POST("about")
    Call<AboutModel> ABOUT_MODEL_CALL(@Field("language") String language);

    @FormUrlEncoded
    @POST("bmember")
    Call<AboutBoardMemberModel>ABOUT_BOARD_MEMBER_MODEL_CALL(@Field("language") String language);


    @FormUrlEncoded
    @POST("volunteer_login")
    Call<VolunteerLoginModel> VOLUNTEER_LOGIN_MODEL_CALL(@FieldMap Map<String, String> params);

}