<template>
  <div>
    <p>

      <button v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        add sold item
      </button>
      &nbsp;&nbsp;
      <button v-on:click="list()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        refresh
      </button>
    </p>


    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
        <th>product name</th>
        <th>unique product code</th>
        <th>category</th>
        <th>sold date</th>
        <th>sold price</th>
        <th>sold quantity</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="soldItem in soldItems">
        <td>{{soldItem.product.productName}}</td>
        <td>{{soldItem.product.id}}</td>
        <td>{{soldItem.product.category.categoryName}}</td>
        <td>{{soldItem.soldDate}}</td>
        <td>{{soldItem.soldPrice}}</td>
        <td>{{soldItem.soldQuantity}}</td>
      </tr>
      </tbody>
    </table>
    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Sold Item Form</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">product name</label>
                <div class="col-sm-10">
                  <select v-model="soldItem.product" class="form-control">
                    <option v-for="v in products" v-bind:value="v">{{v.productName}}</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">sold date</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.soldDate" type="date"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">sold price</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.soldPrice" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">sold quantity</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.soldQuantity" class="form-control">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
            <button v-on:click="save()" type="button" class="btn btn-primary">save</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
  </div>
</template>

<script>
  export default {

    name: "business-member",
    data: function () {
      return {
        soldItem: {},
        soldItems: [],
        categorys: [],
        products: [],
      }
    },
    mounted: function () {
      let _this = this;

       _this.list();

      _this.allProducts();

      // this.$parent.activeSidebar("business-member-sidebar");

    },
    methods: {
      allProducts() {
        let _this = this;
        Loading.show();
        _this.$ajax.get(process.env.VUE_APP_SERVER + '/profectus-buy/business/product/all').then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.products = resp.content;
        })
      },
      add() {
        let _this = this;
        _this.soldItem = {};
        $("#form-modal").modal("show");
      },

      list() {
        let _this = this;
        Loading.show();
        _this.$ajax.get(process.env.VUE_APP_SERVER + '/profectus-buy/business/sold/all').then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.soldItems = resp.content;
        })
      },
      save() {
        let _this = this;
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/profectus-buy/business/sold/save', _this.soldItem).then((response) => {
          Loading.hide();
          let resp = response.data;
          if (resp.success) {
            $("#form-modal").modal("hide");
            _this.list();
            Toast.success("save sold item success！");
          } else {
            Toast.warning(resp.message)
          }
        })
      },
    }
  }
</script>
