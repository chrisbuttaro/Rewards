<div class="fieldcontain">
    <label for= "firstName">
        First Name
    </label>
    <g:textField name="firstName" value ="${firstName}"/>

</div>

<div class="fieldcontain">
    <label for= "comments">
        Comments
    </label>
    <g:textArea name="Comments" value ="${comments}"/>

</div>

<div class="fieldcontain">
    <label for= "password">
        Password
    </label>
    <g:passwordField name="Password" value ="${password}"/>

</div>

<div class="fieldcontain">
    <label for= "notify">
        Would you like email notifications?
    </label>
    <g:checkBox name="notify" value ="${notify}"/>

</div>

<div class="fieldcontain">
    <label for= "gender">
        Gender:
    </label>
    <g:radioGroup name="gender" labels="['Male', 'Female']" values="['M', 'F']" value ="${gender}" >
        <!-- "it" gets the current item in the loop -->
        ${it.label} ${it.radio}
    </g:radioGroup>


</div>

<div class="fieldcontain">
    <label for= "marketing">
        How did you hear about us?
    </label>
    <g:select from="['internet', 'friend', 'other']" name="marketing" value ="${marketing}"/>

</div>