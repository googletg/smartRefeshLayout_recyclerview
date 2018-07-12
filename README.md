# smartRefeshLayout_recyclerview

smartRefreshLayout嵌套recyclerview
页面情景:
列表上方有多行文本显示，文本下方是列表，整个页面可下拉刷新上拉加载，下拉位置从页面最顶部
页面布局为 smartRefreshLayout -scrollview - 文本布局+recyclerview
出现的问题
1 滑动时页面不是整体滑动，滑动部分为recyclerview
2 页面滑动卡顿
3 部分手机数据显示不全

该问题在6.0上出现，6.0之前该写法没问题
解决方案：
1 将scrollView替换为android.support.v4.widget.NestedScrollView 数据可完整显示
2 在代码中设置以下属性

 LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
  //设置滑动流畅性
  linearLayoutManager.setSmoothScrollbarEnabled(true);
  linearLayoutManager.setAutoMeasureEnabled(true);
  recyclerView.setHasFixedSize(true);
  recyclerView.setNestedScrollingEnabled(false);
  recyclerView.setLayoutManager(linearLayoutManager);
  可解决页面滑动不流畅现象。
