<template>
  <div>
    <p>
      <button v-on:click="list()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>

    <div class="row">
      <label class="col-sm-2 control-label">profit category and products</label>
      <div class="col-sm-10">
        <ul id="tree" class="ztree"></ul>
      </div>
      <div class="col-md-6">
        <label class="col-sm-2 control-label">profit calculate from date</label>
        <div class="col-sm-10">
          <input v-model="profitSearchVo.searchFromDate" type="date" class="form-control">
        </div>
        <br>
      </div>
      <div class="col-md-6">
        <label class="col-sm-2 control-label">profit calculate to date</label>
        <div class="col-sm-10">
          <input v-model="profitSearchVo.searchToDate" type="date" class="form-control">
        </div>
        <br>
      </div>
      <div class="col-md-6">
        <label class="col-sm-2 control-label">purchase price from</label>
        <div class="col-sm-10">
          <input v-model="profitSearchVo.priceFrom" class="form-control">
        </div>
        <br>
      </div>
      <div class="col-md-6">
        <label class="col-sm-2 control-label">purchase price to</label>
        <div class="col-sm-10">
          <input v-model="profitSearchVo.priceTo"  class="form-control">
        </div>
        <br>
      </div>
      <div class="col-md-6">
        <button id="save-btn" type="button" class="btn btn-primary" v-on:click="save()">
          save
        </button>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: "business-profit",
    data: function() {
      return {
        products: [],
        tree: {},
        profitSearchVo: {}
      }
    },
    mounted: function() {
      let _this = this;
      _this.list();
      _this.allCategory();
      // this.$parent.activeSidebar("system-resource-sidebar");

    },
    methods: {
      allCategory() {
        let _this = this;
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/category/all').then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.categorys = resp.content;

          _this.initTree();
        })
      },

      list() {
        let _this = this;
        Loading.show();
        _this.$ajax.get(process.env.VUE_APP_SERVER + '/system/admin/resource/load-tree').then((res) => {
          Loading.hide();
          let response = res.data;
          _this.resources = response.content;

          _this.initTree();
        })
      },


      save() {
        let _this = this;

        let products = _this.tree.getCheckedNodes();
        if (Tool.isEmpty(products)) {
          Toast.warning("please choose the products or categories！");
          return;
        }
        _this.profitSearchVo.products = products;

        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/course/save', _this.course).then((response)=>{
          Loading.hide();
          let resp = response.data;
          if (resp.success) {
            $("#form-modal").modal("hide");
            _this.list(1);
            Toast.success("Save Success！");
          } else {
            Toast.warning(resp.message)
          }
        })
      },

      initTree() {
        let _this = this;
        let setting = {
          check: {
            enable: true
          },
          data: {
            simpleData: {
              idKey: "id",
              pIdKey: "parent",
              rootPId: "00000000",
              enable: true
            }
          }
        };

        let zNodes = _this.products;

        _this.tree = $.fn.zTree.init($("#tree"), setting, zNodes);

        // _this.tree.expandAll(true);
      }
    }
  }
</script>