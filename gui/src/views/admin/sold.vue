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
        <th>unique product code</th>
        <th>category</th>
        <th>name</th>
        <th>sold date</th>
        <th>sold price</th>
        <th>sold quantity</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="soldItem in soldItems">
        <td>{{soldItem.id}}</td>
        <td>{{soldItem.category}}</td>
        <td>{{soldItem.name}}</td>
        <td>{{soldItem.soldDate}}</td>
        <td>{{soldItem.soldPrice}}</td>
        <td>{{soldItem.SoldQuantity}}</td>
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
                <label class="col-sm-2 control-label">category</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.category" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">name</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.name" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">sold date</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.purchaseDate" type="date"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">sold price</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.purchasePrice" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">sold quantity</label>
                <div class="col-sm-10">
                  <input v-model="soldItem.purchaseQuantity" class="form-control">
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
        _this.purchasedItem = {};
        $("#form-modal").modal("show");
      },

      list() {
        let _this = this;
        Loading.show();
        _this.$ajax.get(process.env.VUE_APP_SERVER + '/business/item/getSoldItems').then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.soldItems = resp.content.list;
        })
      }
    }
  }
</script>
