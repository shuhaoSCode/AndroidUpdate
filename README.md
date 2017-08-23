# AndroidBeatUpdate
制作一个Android最简洁的更新组件
感觉GitHub上的更新太臃肿，很多主题包，还有很多其实根本用不上的功能，导致体积很大.于是自己写了一个
## 如何导入？

* Android Studio

		allprojects {
			repositories {
			  ...
			  maven { url 'https://jitpack.io' }
			}
		}
		  
		dependencies {
			compile 'com.github.shuhaoSCode:AndroidBeatUpdate:-SNAPSHOT'
		}

* eclipse。。。请自行copy class。

## 当前功能
* 下载apk
* 自动安装
* 下载进度百分比监听

## 简单使用

	UpdateManager.getInstance(this).downloadApk("下载链接", "想要保存的名称.apk").isOpenApk(true).setDownloadInProgessLintener(new UpdateManager.DownloadInProgressLintener() {
        @Override
        public void inProgress(int progress) {
            Log.e(TAG, "downloadInProgress: " + progress);
        }
    });

## 详细说明
* 初始化
	
	```
	UpdateManager.getInstance(this)
	```
* 下载
 
	```
	UpdateManager.downloadApk("下载链接", "想要保存的名称.apk")
	```
* 下载完成后是否打开（默认false 不打开）

	```
	UpdateManager.isOpenApk(true) 
	```
* 监听器

	```
	UpdateManager.setDownloadInProgessLintener(new UpdateManager.DownloadInProgressLintener() {
        @Override
        public void inProgress(int progress) {
        	//progress下载百分比
            Log.e(TAG, "downloadInProgress: " + progress)；
        }
    });
	```
