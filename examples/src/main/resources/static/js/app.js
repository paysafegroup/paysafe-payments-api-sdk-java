// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

// Refund modal
function openRefundModal(txId, paymentMethod) {
    var form  = document.getElementById('refundModalForm');
    var title = document.getElementById('refundModalTitle');
    var msg   = document.getElementById('refundModalMessage');
    form.action = '/refund/' + txId;
    if (paymentMethod === 'PAYSAFECARD' || paymentMethod === 'PAYSAFECASH') {
        title.textContent = 'Refund – ' + (paymentMethod === 'PAYSAFECARD' ? 'PaysafeCard' : 'PaysafeCash');
        msg.textContent = 'Enter the registered PaysafeCard email to which the refund will be sent.';
    } else {
        title.textContent = 'Refund';
        msg.textContent = '';
    }
    document.getElementById('customerAccountId').value = '';
    document.getElementById('refundModal').style.display = 'flex';
}

function closeRefundModal() {
    document.getElementById('refundModal').style.display = 'none';
}

// Card fields toggle
function toggleCardFields() {
    var method = document.getElementById('paymentMethod').value;
    var showCard   = (method === 'CARD');
    var showPaypal = (method === 'PAYPAL');
    var showSkrill = (method === 'SKRILL');
    document.getElementById('cardFields').style.display    = showCard   ? 'block' : 'none';
    document.getElementById('testCardsHint').style.display = showCard   ? 'block' : 'none';
    document.getElementById('paypalFields').style.display  = showPaypal ? 'block' : 'none';
    document.getElementById('skrillFields').style.display  = showSkrill ? 'block' : 'none';
}

// Address line 2 placeholder
function updateAddressLine2() {
    document.getElementById('address2OptLabel').textContent = ' (opt.)';
}

// Expiry auto-format (MM/YY)
document.getElementById('expiry').addEventListener('input', function (e) {
    var v = e.target.value.replace(/\D/g, '');
    if (v.length >= 2) v = v.substring(0, 2) + '/' + v.substring(2, 4);
    e.target.value = v;
});

// Init
document.addEventListener('DOMContentLoaded', function () {
    var select       = document.getElementById('paymentMethod');
    var backendValue = document.getElementById('paymentMethodBackendValue');
    if (backendValue && backendValue.value && select.value !== backendValue.value) {
        select.value = backendValue.value;
    }
    toggleCardFields();
    updateAddressLine2();
    select.addEventListener('change', function () {
        toggleCardFields();
        updateAddressLine2();
    });
});
