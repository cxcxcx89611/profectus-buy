<template>
  <div>
    <div class="modal-content" width>
      <div class="modal-body">
        <form class="form-horizontal">
          <div class="form-group">
            <label class="col-sm-6 control-label">
              <p align="left">
                Assumption:
                <br>1. So called "profit" means that the sum of each product profit. Each product profit means total sold
                price minus total purchased price(can be obtained by sold quantity multiply purchased unit price).
                product can be filtered by category, product name, date range and purchased price range.<br/>
                <br>2. Users search category name indicate user want to get all the products under this category.<br/>
                <br>3. If both category names and product names appeared in search conditions, product names will be
                ignored. Only category name will be used to search products.<br/>
                <br>4. Please note search field is case sensitive<br/>
              </p>
            </label>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">category list</label>
            <div class="col-sm-8">
              <input v-model="profitSearchVo.categoryList" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">product list</label>
            <div class="col-sm-8">
              <input v-model="profitSearchVo.productList" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">date from</label>
            <div class="col-sm-8">
              <input v-model="profitSearchVo.searchFromDate" type="date"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">date to</label>
            <div class="col-sm-8">
              <input v-model="profitSearchVo.searchToDate" type="date"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">purchased from price</label>
            <div class="col-sm-8">
              <input v-model="profitSearchVo.priceFrom" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">purchased to price</label>
            <div class="col-sm-8">
              <input v-model="profitSearchVo.priceTo" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">profit (AUD): </label>
            <div class="col-sm-8">
              <input v-model="profitResult" class="form-control">
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button v-on:click="search()" type="button" class="btn btn-primary">Search</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "business-profit",
    data: function () {
      return {
        profitSearchVo: {},
        profitResult: "$ 0",
      }
    },
    mounted: function () {
      let _this = this;

    },
    methods: {
      search() {
        let _this = this;
        Loading.show();
        console.log(_this.profitSearchVo);
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/profectus-buy/business/profit/calculate', _this.profitSearchVo).then((response) => {
          Loading.hide();
          let resp = response.data;
          if (resp.success) {
            _this.profitResult = resp.content;
            Toast.success("calculate profit success!");
          } else {
            Toast.warning(resp.message)
          }
        })
      }
    }
  }
</script>