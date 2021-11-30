#### 退出RN后，将返回结果通知给Native
1. **JS主动退出RN** startActivityForResult吊起RN，JS可以调用Native方法通过finish退出RN和setResult回传数据给吊起RN的Native Activity。
2. **返回键退出RN** onBackPressed要先获取RN需要回传的数据，RN端可以通过EventEmitter监听onBackPressed的调用，进行数据的回传给Native Activity。 invokeDefaultOnBackPressed
3. Pause、Stop、Destroy，当这些生命周期函数调用时，虽然可以执行JS方法回传数据给Native Module，再处理Native Module返回的数据，但是会造成React Activity退出延迟。就算是不处理Promise返回的数据，也会造成延迟。不知道有什么影响？？？
4. 这个基本上就涵盖所有情况了。