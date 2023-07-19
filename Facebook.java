package com.coderfaysal.fbads.ads;

import android.app.Activity;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class Facebook {

    public static void showBanner(LinearLayout container, Activity activity){

        if (Ads.isAds && Ads.isBanner){
            AdView adView = new AdView(activity, Ads.BANNER, AdSize.BANNER_HEIGHT_50);
            container.removeAllViews();
            container.addView(adView);
            AdListener adListener = new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {

                }

                @Override
                public void onAdLoaded(Ad ad) {

                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            };
            adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());

        }


    }

    public static void loadInter (Activity activity){

        if (Ads.isAds && Ads.isInterstitial){

            Ads.interstitialAd = new InterstitialAd(activity, Ads.INTERSTITIAL);

            InterstitialAdListener adListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {

                }

                @Override
                public void onInterstitialDismissed(Ad ad) {

                    Ads.interstitialAd = null;
                    loadInter(activity);
                }

                @Override
                public void onError(Ad ad, AdError adError) {

                }

                @Override
                public void onAdLoaded(Ad ad) {

                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            };

            Ads.interstitialAd.loadAd(Ads.interstitialAd.buildLoadAdConfig().withAdListener(adListener).build());

        }

    }

    public static void showInter(){
        if (Ads.interstitialAd == null || !Ads.interstitialAd.isAdLoaded()){
            return;
        }
        if (Ads.interstitialAd.isAdInvalidated()){
            return;
        }
        Ads.interstitialAd.show();
    }


}
