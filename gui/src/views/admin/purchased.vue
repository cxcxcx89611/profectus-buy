<template>
  <div>
    <p>
      <button v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        add purchased item
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
        <th>purchased date</th>
        <th>purchased price</th>
        <th>purchased quantity</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="purchasedItem in purchasedItems">
        <td>{{purchasedItem.product.productName}}</td>
        <td>{{purchasedItem.product.id}}</td>
        <td>{{purchasedItem.product.category.categoryName}}</td>
        <td>{{ purchasedItem.purchasedDate}}</td>
        <td>{{purchasedItem.purchasedPrice}}</td>
        <td>{{purchasedItem.purchasedQuantity}}</td>
      </tr>
      </tbody>
    </table>
    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
              aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Purchased Item Form</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">product name</label>
                <div class="col-sm-10">
                  <select v-model="purchasedItem.product" class="form-control">
                    <option v-for="v in products" v-bind:value="v">{{v.productName}}</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">purchased date</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.purchasedDate" type="date"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">purchased price</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.purchasedPrice" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">purchased quantity</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.purchasedQuantity" class="form-control">
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
    name: "business-purchased",
    data: function () {
      return {
        purchasedItem: {},
        purchasedItems: [],
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
        _this.purchasedItem = {};
        $("#form-modal").modal("show");
      },

      list() {
        console.log("send request");
        let _this = this;
        Loading.show();
        _this.$ajax.get(process.env.VUE_APP_SERVER + '/profectus-buy/business/purchased/all').then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.purchasedItems = resp.content;
          console.log(_this.purchasedItems);
        })
        console.log("send request end");
      },

      save() {
        let _this = this;
        if (1 != 1
          || !Validator.length(_this.purchasedItem.purchasedPrice, "Price",  1, 6)
          || !Validator.length(_this.purchasedItem.purchasedQuantity, "Quantity", 1, 6)
        ) {
          return;
        }

        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/profectus-buy/business/purchased/save', _this.purchasedItem).then((response) => {
          Loading.hide();
          let resp = response.data;
          if (resp.success) {
            $("#form-modal").modal("hide");
            _this.list();
            Toast.success("save purchased item success！");
          } else {
            Toast.warning(resp.message)
          }
        })
      },
    }
  }
</script>
