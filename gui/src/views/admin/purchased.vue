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
        <th>unique product code</th>
        <th>category</th>
        <th>name</th>
        <th>purchased date</th>
        <th>purchased price</th>
        <th>purchased quantity</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="purchasedItem in purchasedItems">
        <td>{{purchasedItem.id}}</td>
        <td>{{purchasedItem.category}}</td>
        <td>{{purchasedItem.name}}</td>
        <td>{{purchasedItem.purchaseDate}}</td>
        <td>{{purchasedItem.purchasePrice}}</td>
        <td>{{purchasedItem.purchaseQuantity}}</td>
      </tr>
      </tbody>
    </table>
    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Purchased Item Form</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">category</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.category" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">name</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.name" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">purchased date</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.purchaseDate" type="date"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">purchased price</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.purchasePrice" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">purchased quantity</label>
                <div class="col-sm-10">
                  <input v-model="purchasedItem.purchaseQuantity" class="form-control">
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
      }
    },
    mounted: function () {
      let _this = this;

      // _this.list();

      this.$parent.activeSidebar("business-member-sidebar");

    },
    methods: {

      add() {
        let _this = this;
        _this.teacher = {};
        $("#form-modal").modal("show");
      },

      list() {
        let _this = this;
        Loading.show();
        _this.$ajax.get(process.env.VUE_APP_SERVER + '/business/item/getPurchasedItems').then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.purchased = resp.content.list;
        })
      }
    }
  }
</script>
