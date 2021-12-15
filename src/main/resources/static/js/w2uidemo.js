var config = {
    layout: {
        name: 'layout',
        padding: 4,
        panels: [
            {type: 'left', size: '50%', resizable: true, minSize: 300},
            {type: 'main', minSize: 300}
        ]
    },
    grid: {
        name: 'grid',
        url: '/master/customer/customerJson',
        show: {
            toolbar: true,
            toolbarDelete: true,
            selectColumn: true
        },
        columns: [
            {field: 'customerName', caption: 'First Name', size: '33%', sortable: true, searchable: true},
            {field: 'customerEmail', caption: 'Customer Email', size: '33%', sortable: true, searchable: true},
            {field: 'customerAddress', caption: 'Customer Address', size: '33%'},
            {field: 'companyId', caption: 'Start Date', size: '120px', render: 'date'}
        ],
        onClick: function (event) {
            var grid = this;
            var form = w2ui.form;
            console.log(event);
            event.onComplete = function () {
                var sel = grid.getSelection();
                console.log(sel);
                if (sel.length == 1) {
                    form.recid = sel[0];
                    form.record = $.extend(true, {}, grid.get(sel[0]));
                    form.refresh();
                } else {
                    form.clear();
                }
            }
        }
    },
    form: {
        header: 'Edit Record',
        name: 'form',
        fields: [
            {name: 'recid', type: 'text', html: {caption: 'Customer ID', attr: 'size="10" readonly'}},
            {
                name: 'customerName',
                type: 'text',
                required: true,
                html: {caption: 'customerName', attr: 'size="40" maxlength="40"'}
            },
            {
                name: 'customerAddress',
                type: 'text',
                required: true,
                html: {caption: 'customer Address', attr: 'size="40" maxlength="40"'}
            },
            {name: 'companyId', type: 'email', html: {caption: 'Company Id', attr: 'size="30"'}},
            {name: 'customerEmail', type: 'text', html: {caption: 'Customer Email', attr: 'size="10"'}}
        ],
        actions: {
            Reset: function () {
                this.clear();
            },
            Save: function () {
                var errors = this.validate();
                if (errors.length > 0) return;
                if (this.recid == 0) {
                    w2ui.grid.add($.extend(true, this.record, {recid: w2ui.grid.records.length + 2}));
                    w2ui.grid.selectNone();
                    this.clear();
                } else {
                    w2ui.grid.set(this.recid, this.record);
                    w2ui.grid.selectNone();
                    this.clear();
                }
            }
        }
    }
};

$(function () {
    // initialization
    $('#myGrid').w2layout(config.layout);
    w2ui.layout.content('left', $().w2grid(config.grid));
    w2ui.layout.content('main', $().w2form(config.form));
});